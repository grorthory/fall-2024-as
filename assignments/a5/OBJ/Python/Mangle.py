#Mangle:top#
#Mangle:import#

# <mangle> **= RANGLE <exp> LPAREN <rands> RPAREN
class Mangle(): #Mangle:class#

    className = "Mangle"
    ruleString = "<mangle> **= RANGLE <exp> LPAREN <rands> RPAREN"
    expList = None
    randsList = None

    def __init__(expList, randsList):
        #Mangle:init#
        self.expList = expList
        self.randsList = randsList

#Mangle#
