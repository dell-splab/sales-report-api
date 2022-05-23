
# Generating data.sql

>The `dataloader.py` is a simple Python script to read data and create a `data.sql` file to be loaded by SpringBoot framework.

## Python Requirements

```bash
pip install -r requirements.txt
```

## Usage

```
bash build_data.sh
```

Or

```bash
python3 dataloader.py -i ../rawdata/clients.csv --sql -a data.sql
python3 dataloader.py -i ../rawdata/products.csv --sql -a data.sql
python3 dataloader.py -i ../rawdata/leads.csv --sql -a data.sql
python3 dataloader.py -i ../rawdata/sales.log  --sql -a data.sql
```


