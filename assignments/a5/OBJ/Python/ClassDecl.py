#ClassDecl:top#
#ClassDecl:import#

# <classDecl> ::= CLASS <ext> <statics> <fields> <methods> END
class ClassDecl(): #ClassDecl:class#

    className = "ClassDecl"
    ruleString = "<classDecl> ::= CLASS <ext> <statics> <fields> <methods> END"
    ext = None
    statics = None
    fields = None
    methods = None

    def __init__(ext, statics, fields, methods):
        #ClassDecl:init#
        self.ext = ext
        self.statics = statics
        self.fields = fields
        self.methods = methods

#ClassDecl#
