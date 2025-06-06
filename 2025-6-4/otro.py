import csv

# Datos para escribir en el archivo CSV
data = [
    ['Nombre', 'Edad', 'Ciudad'],
    ['Juan', 25, 'Lima'],
    ['María', 30, 'Arequipa'],
    ['Carlos', 22, 'Cusco']
]

# Abrir (o crear) el archivo CSV en modo escritura
with open('personas.csv', mode='w', newline='') as file:
    writer = csv.writer(file)
    
    # Escribir los datos en el archivo
    writer.writerows(data)

print("CSV creado exitosamente.")
