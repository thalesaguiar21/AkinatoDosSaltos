from PredicaoDeUmBit import *
from PredicaoDeDoisBits import *
from PredicaoMisteriosa import *
from TwoLevelAdaptive import *

class FabricaDePreditores(object):

	def criarPreditor(self, tipoDePreditor):
		if(tipoDePreditor == 1):
			return PredicaoDeUmBit()
		elif(tipoDePreditor == 2):
			return PredicaoDeDoisBits()
		elif(tipoDePreditor == 3):
			return PredicaoMisteriosa()
		elif(tipoDePreditor == 4):
			return TwoLevelAdaptive()
		else:
			print('Tipo de preditor inexistente')