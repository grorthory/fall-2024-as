#Ext1:top#
#Ext1:import#

# <ext>:Ext1 ::= EXTENDS <exp>
class Ext1(Ext): #Ext1:class#

    className = "Ext1"
    ruleString = "<ext>:Ext1 ::= EXTENDS <exp>"
    exp = None

    def __init__(exp):
        #Ext1:init#
        self.exp = exp

#Ext1#
