#ChrExp:top#
#ChrExp:import#

# <exp>:ChrExp ::= <CHR>
class ChrExp(Exp): #ChrExp:class#

    className = "ChrExp"
    ruleString = "<exp>:ChrExp ::= <CHR>"
    chr = None

    def __init__(chr):
        #ChrExp:init#
        self.chr = chr

#ChrExp#
