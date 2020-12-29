package pkg.API_Project

class Actvity1{
	public static void main(def args)
	{
	
	def inputList =[11, 2, 19, 5, "Mango", "Apple", "Watermelon"]
	def strlist=inputList.minus([11, 2, 19, 5])
	def intlist=inputList.minus(["Mango", "Apple", "Watermelon"])
	println strlist
	println intlist
	println "Sorted string :"+strlist.sort()
	println "Sorted string :"+intlist.sort()
}

}