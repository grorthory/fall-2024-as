#ListExp:top#
#ListExp:import#

# <exp>:ListExp ::= LBRACK <rands> RBRACK
class ListExp(Exp): #ListExp:class#

    className = "ListExp"
    ruleString = "<exp>:ListExp ::= LBRACK <rands> RBRACK"
    rands = None

    def __init__(rands):
        #ListExp:init#
        self.rands = rands

#ListExp#
