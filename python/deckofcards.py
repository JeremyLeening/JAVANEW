suits = ['hearts', 'diamonds', 'clubs', 'spades']
values = ['Ace', '2', '3', '4', '5', '6', '7', '8', '9', '10', 'Jack', 'Queen', 'King']

class Card():
    def __init__(self, suit, value):
        self.suit = suit
        self.value = value

class Deck():
    
    def __init__(self):
        self.decklist = []
        for suit in suits:
            for value in values:
                self.decklist.append(Card(suit,value))

    def show(self):
        cards = []
        for card in self.decklist:
            cards.append(card.value + ' of ' + card.suit)
        return cards
    
test = Deck()
print(test.show())
