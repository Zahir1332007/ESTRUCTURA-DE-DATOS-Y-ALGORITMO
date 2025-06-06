import turtle
import colorsys

turtle.bgcolor("black")
turtle.speed(1)
turtle.tracer(10)  # animación más rápida

turtle.penup()
turtle.goto(0, -150)
turtle.pendown()

for i in range(30):
    color = colorsys.hsv_to_rgb(i / 30, 1, 1)
    turtle.color(color)
    turtle.circle(150 - i * 4)
turtle.hideturtle()
turtle.done()
