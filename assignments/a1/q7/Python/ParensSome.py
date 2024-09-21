#ParensSome:top#
#ParensSome:import#

# <parens>ParensSome ::= LP <parens> RP
class ParensSome(Parens): #ParensSome:class#

    className = "ParensSome"
    ruleString = "<parens>ParensSome ::= LP <parens> RP"
    parens = None

    def __init__(parens):
        #ParensSome:init#
        self.parens = parens

#ParensSome#
