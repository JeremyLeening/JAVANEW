connections = [
    ('Amsterdam', 'Dublin', 100),
    ('Amsterdam', 'Rome', 140),
    ('Rome', 'Warsaw', 130),
    ('Minsk', 'Prague', 95),
    ('Stockholm', 'Rome', 190),
    ('Copenhagen', 'Paris', 120),
    ('Madrid', 'Rome', 135),
    ('Lisbon', 'Rome', 170),
    ('Dublin', 'Rome', 170),
    ]
count = 0
time = 0
for connection in connections:
    if connection[0] == 'Rome':
        count += 1
        time += connection[2]
    if connection[1] == 'Rome':
        count += 1
        time += connection[2]
avgtime = time / count
        
    
print(str(count)+' connections lead to Rome with an average flight time of '+str(avgtime)+' minutes')