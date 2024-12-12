#PutcExp:top#
#PutcExp:import#

# <exp>:PutcExp ::= PUTC <exp>
class PutcExp(Exp): #PutcExp:class#

    className = "PutcExp"
    ruleString = "<exp>:PutcExp ::= PUTC <exp>"
    exp = None

    def __init__(exp):
        #PutcExp:init#
        self.exp = exp

#PutcExp#
