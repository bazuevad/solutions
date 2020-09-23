from spherov2 import scanner
from spherov2.sphero_edu import SpheroEduAPI
from spherov2.types import Color

toy = scanner.find_toy()
# with SpheroEduAPI(toy) as droid:
#     droid.roll(0, 100, 4)

def drive_with_commands(droid, commands):
    for x in commands:
        droid.roll(x[0],x[1],x[2])

def drive_polygon(droid,n):
    output = []
    int_angle = (n-2)*180/n
    ext_angle = (int)(180-int_angle)
    a = 0
    while n > 0:
        output.append(tuple((a,100,1)))
        a=a+ext_angle
        n-=1
    drive_with_commands(droid,output)


with SpheroEduAPI(toy) as droid:
    #roll_commands = [(0, 100, 1), (72, 100, 1), (144, 100, 1), (216, 100, 1), (288, 100, 1)]
    #Triangle
    roll_commands = [(0,100,2),(120,100,2),(240,100,2)]
    #drive_with_commands(droid, roll_commands)
    # drive_polygon(droid,3)
    # drive_polygon(droid,4)
    # drive_polygon(droid,5)
    droid.set_main_led(Color(r=0, g=0, b=255))



