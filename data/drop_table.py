import oracledb
import os

username = os.getenv('DB_USER', 'system')
password = os.getenv('DB_PASSWORD', 'Oracle123')
dsn = f"{os.getenv('DB_HOST', 'localhost')}:{os.getenv('DB_PORT', '1521')}/{os.getenv('DB_SERVICE', 'XEPDB1')}"

connection = oracledb.connect(user=username, password=password, dsn=dsn)
cursor = connection.cursor()

try:
    cursor.execute("DROP TABLE STOCKTRADES")
    print(" Table stockstrades dropped successfully")
except oracledb.Error as e:
    print(f"Table not dropped : {e}")
connection.commit()
