import pandas as pd
import oracledb  # no need to call init_oracle_client

# === Step 1: Load the cleaned CSV ===
csv_file = "cleaned_trades.csv"
df = pd.read_csv(csv_file)

# === Step 2: Connection details
username = "System"
password = "Oracle123"
host = "localhost"
port = 1521
service_name = "ORCLPDB1"

dsn = f"{host}:{port}/{service_name}"

# === Step 3: Connect to Oracle using THIN mode (default)
connection = oracledb.connect(user=username, password=password, dsn=dsn)
cursor = connection.cursor()

# === Step 4: Insert SQL
insert_sql = """
    INSERT INTO STOCKTRADES (
        trade_date, symbol, quantity, price, type, profit_loss, country, industry_tag
    ) VALUES (
        TO_DATE(:1, 'YYYY-MM-DD'),
        :2, :3, :4, :5, :6, :7, :8
    )
"""

# === Step 5: Insert rows
for _, row in df.iterrows():
    cursor.execute(insert_sql, (
        row['trade_date'],
        row['symbol'],
        int(row['quantity']),
        float(row['price']),
        row['type'],
        float(row['profit_loss']),
        row['country'],
        row['industry_tag']
    ))

# === Step 6: Done
connection.commit()
cursor.close()
connection.close()

print("✅ Data successfully inserted into the 'trades' table!")
