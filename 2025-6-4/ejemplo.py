import json

type = "tipo de producto"
uid = "u\00o9digo de producto"
document_number = "87654321"
documnet_type="NATIONAL_ID"
amout = 250
program = "PROGRAM-EMPLOYEE"
place = "ID_PLACE"
description="nombre del producto"
date_consumption = "2019-04-04 20:30:59"

extra = {"type": "tipo de producto",
          "uid" : "codigo de producto"
} 

employee = {"document_number":document_number,
            "document_type":documnet_type,
            "program":program
}

data = {
    "document_type":documnet_type,
    "amount": amout,
    "program":program,
    "place":place,
    "descripcion":description,
    "date_consumption":date_consumption,
    "extra":extra,
    "employee":employee
}

with open('petroperu.json', 'w') as file:
    json.dump(data,file)
print(data)
print("archivo generado con exito")