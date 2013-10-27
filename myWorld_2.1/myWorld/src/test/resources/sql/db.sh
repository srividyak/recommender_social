#/bin/sh
mysql -u srividyak myWorld_test < src/test/resources/sql/schema.sql
mysql -u srividyak myWorld_test < src/test/resources/sql/data.sql