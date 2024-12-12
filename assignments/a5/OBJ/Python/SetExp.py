#SetExp:top#
#SetExp:import#

# <exp>:SetExp ::= SET <loc> <VAR> EQUALS <exp>
class SetExp(Exp): #SetExp:class#

    className = "SetExp"
    ruleString = "<exp>:SetExp ::= SET <loc> <VAR> EQUALS <exp>"
    loc = None
    var = None
    exp = None

    def __init__(loc, var, exp):
        #SetExp:init#
        self.loc = loc
        self.var = var
        self.exp = exp

#SetExp#
