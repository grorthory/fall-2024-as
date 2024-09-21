#ParensMultiple:top#
#ParensMultiple:import#

# <parens>ParensMultiple ::= LP <parens>nested RP <parens>outside
class ParensMultiple(Parens): #ParensMultiple:class#

    className = "ParensMultiple"
    ruleString = "<parens>ParensMultiple ::= LP <parens>nested RP <parens>outside"
    nested = None
    outside = None

    def __init__(nested, outside):
        #ParensMultiple:init#
        self.nested = nested
        self.outside = outside

#ParensMultiple#
