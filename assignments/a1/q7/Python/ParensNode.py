#ParensNode:top#
#ParensNode:import#

# <parens>ParensNode ::= LP <parens> RP
class ParensNode(Parens): #ParensNode:class#

    className = "ParensNode"
    ruleString = "<parens>ParensNode ::= LP <parens> RP"
    parens = None

    def __init__(parens):
        #ParensNode:init#
        self.parens = parens

#ParensNode#
