from PredicaoDeUmBit import *
from PredicaoDeDoisBits import *
from PredicaoMisteriosa import *

class FabricaDePredicoes(object):

	''' Classe para criação de vários tipos de predições '''
	'''
		tipoDePredicao = 1 -> PredicaoDeUmBit
		tipoDePredicao = 2 -> PredicaoDeDoisBits
		tipoDePredicao = 3 -> PredicaoMisteriosa
	'''

	def __init__(self, tipoDePredicao):
		if(tipoDePredicao == 1):
			return PredicaoDeUmBit()
		elif(tipoDePredicao == 2):
			return PredicaoDeDoisBits()
		elif(tipoDePredicao == 3):
			return PredicaoMisteriosa()
		else:
			print('Está não é uma opção válida')
