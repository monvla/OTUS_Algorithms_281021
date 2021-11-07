import pathlib, os
from сonsole_tester import *


class TaskString(Task):
	def run(self, data):
		return self.prepare_result(len(data[0]))



task = TaskString()
tester = Tester(
	task,
	os.path.join(pathlib.Path(__file__).parent.resolve(), "0.String") 
)
tester.run_tests()
