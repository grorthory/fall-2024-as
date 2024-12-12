#StrngExp:top#
#StrngExp:import#

# <exp>:StrngExp ::= <STRNG>
class StrngExp(Exp): #StrngExp:class#

    className = "StrngExp"
    ruleString = "<exp>:StrngExp ::= <STRNG>"
    strng = None

    def __init__(strng):
        #StrngExp:init#
        self.strng = strng

#StrngExp#
