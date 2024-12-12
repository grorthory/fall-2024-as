#DisplayExp:top#
#DisplayExp:import#

# <exp>:DisplayExp ::= DISPLAY <exp>
class DisplayExp(Exp): #DisplayExp:class#

    className = "DisplayExp"
    ruleString = "<exp>:DisplayExp ::= DISPLAY <exp>"
    exp = None

    def __init__(exp):
        #DisplayExp:init#
        self.exp = exp

#DisplayExp#
