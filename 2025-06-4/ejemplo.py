extra = {"type": "tipo de producto",
          "uid" : "codigo de producto"
} 

employee = {"document_number":"87654321",
            "document_type":"NATIONAL_ID",
            "program":"PROGRAM_EMPLOYEE"
}

data = {
    "document_type":"NATIONAL_ID",
    "amount": 250,
    "program":"ID PROGRAM",
    "place":"ID_PLACE",
    "descripcion":"Nombre del producto",
    "date_consumption":"2019-04-04 20:30:59",
    "extra":extra,
    "employee":employee
}

print(data)