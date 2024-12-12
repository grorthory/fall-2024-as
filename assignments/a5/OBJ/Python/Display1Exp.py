#Display1Exp:top#
#Display1Exp:import#

# <exp>:Display1Exp ::= DISPLAY1 <exp>
class Display1Exp(Exp): #Display1Exp:class#

    className = "Display1Exp"
    ruleString = "<exp>:Display1Exp ::= DISPLAY1 <exp>"
    exp = None

    def __init__(exp):
        #Display1Exp:init#
        self.exp = exp

#Display1Exp#
