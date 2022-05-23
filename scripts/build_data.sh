#!usr/bin/bash

OUTPUT_FILE="data.sql"

python3 dataloader.py -i ../rawdata/clients.csv --sql -a $OUTPUT_FILE
python3 dataloader.py -i ../rawdata/products.csv --sql -a $OUTPUT_FILE
python3 dataloader.py -i ../rawdata/leads.csv --sql -a $OUTPUT_FILE
python3 dataloader.py -i ../rawdata/sales.log --sql -a $OUTPUT_FILE