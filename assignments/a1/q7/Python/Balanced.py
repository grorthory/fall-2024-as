#Balanced:top#
#Balanced:import#

# <balanced> ::= <parens> AT
class Balanced(_Start): #Balanced:class#

    className = "Balanced"
    ruleString = "<balanced> ::= <parens> AT"
    parens = None

    def __init__(parens):
        #Balanced:init#
        self.parens = parens

#Balanced#
