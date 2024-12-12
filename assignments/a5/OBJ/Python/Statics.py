#Statics:top#
#Statics:import#

# <statics> **= STATIC <VAR> EQUALS <exp>
class Statics(): #Statics:class#

    className = "Statics"
    ruleString = "<statics> **= STATIC <VAR> EQUALS <exp>"
    varList = None
    expList = None

    def __init__(varList, expList):
        #Statics:init#
        self.varList = varList
        self.expList = expList

#Statics#
