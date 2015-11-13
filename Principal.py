from Predicao import *
from PredicaoDeUmBit import *
from PredicaoDeDoisBits import *
from PredicaoMisteriosa import *
from TwoLevelAdaptive import *


testePredMisteriosa = TwoLevelAdaptive()
testePredMisteriosa.setListaDeSaltos('teste.txt')
testePredMisteriosa.predizer()
print(testePredMisteriosa.getPorcentagemDeAcertos())
print(testePredMisteriosa.getPredicoesFeitas())
print(testePredMisteriosa.getListaDeSaltos())
