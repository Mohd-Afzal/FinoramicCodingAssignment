import subprocess
import sys
import json
from pprint import pprint

with open('data.json') as f:
    data = json.load(f)

failed = []

for item in data["Dependencies"]:
	result = subprocess.call([sys.executable, "-m", "pip", "install", item])
	if result != 0:
		failed.append(item)
		
if len(failed) == 0:
	print ("success")
else:
	print("failed packages:")
	for item in failed:
		print(item)
