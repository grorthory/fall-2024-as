#ErrorExp:top#
#ErrorExp:import#

# <exp>:ErrorExp ::= ERROR <exp>
class ErrorExp(Exp): #ErrorExp:class#

    className = "ErrorExp"
    ruleString = "<exp>:ErrorExp ::= ERROR <exp>"
    exp = None

    def __init__(exp):
        #ErrorExp:init#
        self.exp = exp

#ErrorExp#
