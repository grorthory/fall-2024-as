#EenvExp:top#
#EenvExp:import#

# <exp>:EenvExp ::= LLANGLE <exp> <mangle> RRANGLE
class EenvExp(Exp): #EenvExp:class#

    className = "EenvExp"
    ruleString = "<exp>:EenvExp ::= LLANGLE <exp> <mangle> RRANGLE"
    exp = None
    mangle = None

    def __init__(exp, mangle):
        #EenvExp:init#
        self.exp = exp
        self.mangle = mangle

#EenvExp#
