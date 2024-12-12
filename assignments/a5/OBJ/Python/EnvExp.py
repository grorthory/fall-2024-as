#EnvExp:top#
#EnvExp:import#

# <exp>:EnvExp ::= LANGLE <exp>vExp RANGLE <exp>eExp
class EnvExp(Exp): #EnvExp:class#

    className = "EnvExp"
    ruleString = "<exp>:EnvExp ::= LANGLE <exp>vExp RANGLE <exp>eExp"
    vExp = None
    eExp = None

    def __init__(vExp, eExp):
        #EnvExp:init#
        self.vExp = vExp
        self.eExp = eExp

#EnvExp#
