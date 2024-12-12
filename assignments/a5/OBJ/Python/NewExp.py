#NewExp:top#
#NewExp:import#

# <exp>:NewExp ::= NEW <exp>
class NewExp(Exp): #NewExp:class#

    className = "NewExp"
    ruleString = "<exp>:NewExp ::= NEW <exp>"
    exp = None

    def __init__(exp):
        #NewExp:init#
        self.exp = exp

#NewExp#
