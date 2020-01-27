UPDATE producto
SET nombre=:nombre, precio=:precio, cantidad=:cantidad
WHERE codigo = :codigo;