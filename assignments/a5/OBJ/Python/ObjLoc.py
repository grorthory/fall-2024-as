#ObjLoc:top#
#ObjLoc:import#

# <loc>:ObjLoc ::= LANGLE <exp> RANGLE
class ObjLoc(Loc): #ObjLoc:class#

    className = "ObjLoc"
    ruleString = "<loc>:ObjLoc ::= LANGLE <exp> RANGLE"
    exp = None

    def __init__(exp):
        #ObjLoc:init#
        self.exp = exp

#ObjLoc#
