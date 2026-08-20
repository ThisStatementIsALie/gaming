import pygame
import random

seconds = 3
pygame.init()
screen = pygame.display.set_mode((690, 360))
running = True
time = pygame.time.Clock
timeMade = 0
secondsPerCircle = 10
screen.fill("green")
circle = pygame.draw.circle(screen, pygame.Color(255,255,255), (random.randint(10,680), random.randint(10,350)), 15)

while running:
    for event in pygame.event.get():
        if event.type == pygame.MOUSEBUTTONDOWN:
            # if circle != None and circle.collidepoint(pygame.mouse.get_pos()):
                r = random.randint(0,255)
                g = random.randint(0,255)
                b = random.randint(0,255)
                color = pygame.Color(r,g,b)
                screen.fill(color)
                circle = pygame.draw.circle(screen, pygame.Color(255,255,255), (random.randint(10,680), random.randint(10,350)), 15)
                timeMade = time
                pygame.display.flip()
                print("{} {} {}".format(circle.x, circle.y, pygame.mouse.get_pos()))