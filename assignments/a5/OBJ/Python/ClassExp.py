#ClassExp:top#
#ClassExp:import#

# <exp>:ClassExp ::= <classDecl>
class ClassExp(Exp): #ClassExp:class#

    className = "ClassExp"
    ruleString = "<exp>:ClassExp ::= <classDecl>"
    classDecl = None

    def __init__(classDecl):
        #ClassExp:init#
        self.classDecl = classDecl

#ClassExp#
