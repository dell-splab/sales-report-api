import argparse
import logging
import os

import pandas as pd

def get_filename(filepath):
    basename = os.path.basename(filepath).split(".")[0]
    return basename.lower()

def checktype(entry_value):
    if "R$" in str(entry_value):
        entry_value = entry_value.replace("R$", "")
        entry_value = entry_value.replace(".", "")
        return float(entry_value.split(",")[0])
    if str(entry_value).isnumeric():
        return entry_value
    return "'{}'".format(entry_value)

def sql_builder(args, log):
    log.debug('Building SQL data entries')
    entity_name = get_filename(args.filepath)
    data = pd.read_csv(args.filepath)
    data.rename(columns={"timestamp": "created_at"}, inplace=True)
    columns = ", ".join(data.columns)
    with open(args.output_filepath, "a") as sqlfile:
        stmt_header = "\nINSERT INTO {}\n\t({})\nVALUES".format(entity_name, columns.lower())
        sqlfile.write(stmt_header)
        for i, row in data.iterrows():
            stmt_entry = []
            for c in columns.split(", "):
                entry = checktype(row[c])
                stmt_entry.append("{}".format(entry))
            sqlfile.write("{}\n\t({})".format(", "[i==0], ",".join(stmt_entry)))
        sqlfile.write(";\n")
        sqlfile.close()


def json_builder(args, log):
    log.debug('Building JSON')
    pass

def init_cli():
    cli = argparse.ArgumentParser(description="Sales reports data loader helper")
    cli.add_argument("-i", "--input", dest="filepath", required=True, help="Data input filepath")
    cli.add_argument("-o", "--output", dest="output_filepath", default="data.sql", help="Output to filepath")
    cli.add_argument("-a", "--append", dest="append_filepath", default="data.sql", help="Append output to filepath")
    cli.add_argument("-d", "--sql-dialect", dest="dialect", type=str, default="postgres", help="SQL dialect (Default is Postgres)")
    cli.add_argument("-v", dest="verbose", action="store_true", default=False, help="Enable verbose mode")
    cli.add_argument("--csv", dest="csv", action="store_true", default=False, help="Indicates whether the file contents are in CSV format")
    cli.add_argument("--sql", dest="sql", action="store_true", default=False, help="Generates a SQL output")
    cli.add_argument("--json", dest="json", action="store_true", default=False, help="Generates a JSON ouput")

    return cli.parse_args()

if __name__ == "__main__":    
    
    args = init_cli()

    if args.verbose:
        logging.basicConfig(level=logging.DEBUG)
    else:
        logging.basicConfig(level=logging.INFO)

    log = logging.getLogger()
    
    if not args.csv:
        ext = args.filepath[-3:]
        if ext.lower() == "csv":
            log.debug("Reading as CSV file")
            args.csv = True
        else:
            log.debug("Reading a plain-text file")
        
    supported_sql_dialects = ['postgres']

    if args.sql:
        if not args.dialect in supported_sql_dialects:
            log.info("SQL \"{}\" dialect not supported, only {} are available".format(args.dialect, supported_sql_dialects))
        sql_builder(args, log)
    
    if args.json:
        json_builder(args, log)
