import json

print(" ")
print(" ")
with open("petroperu.json") as file:
    data = json.load(file)
print(data)
print(" ")
print(" ")
print(data["extra"])