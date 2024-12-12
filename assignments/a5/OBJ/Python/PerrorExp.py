#PerrorExp:top#
#PerrorExp:import#

# <exp>:PerrorExp ::= PERROR <STRNG>
class PerrorExp(Exp): #PerrorExp:class#

    className = "PerrorExp"
    ruleString = "<exp>:PerrorExp ::= PERROR <STRNG>"
    strng = None

    def __init__(strng):
        #PerrorExp:init#
        self.strng = strng

#PerrorExp#
