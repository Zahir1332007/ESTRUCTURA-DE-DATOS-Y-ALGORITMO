def intersection(lista1, lista2):
    duplicados = []
    for value in lista1:
        if value in lista2:
            duplicados.append(value)
    return duplicados

lista1 = ['roy', 'menor', 'davila']
lista2 = ['zevallos', 'davila', 'guevarra']

print(intersection(lista1, lista2))

for value in lista1:
    if value in lista2:
        print(value)

print(lista1 + lista2)
