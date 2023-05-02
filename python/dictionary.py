sample_dict = {
    "mouth": "Mund",
    "finger": "Finger",
    "leg": "Bein",
    "hand": "Hand",
    "face": "Gesicht",
    "nose": "Nase"
}

while True:
    count = 0
    text = input('Enter a word in English or EXIT: ')
    if text == 'EXIT':
        break
    for i in sample_dict:
        if i==text:
            count += 1
            print('Translation: '+sample_dict[text])
    if count == 0:
        print('No match!')
        

print('Bye!')