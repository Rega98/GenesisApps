class Test {
	public static void main(String[] args){
		int arr[] = {3,1,2,5,4};
		//Pasar el array a un metodo sum
		sum(arr);
	}

	public static void sum(int[] arr){
		//Obtener la suma del array
		int sum = 0;
		for (int i=0; i<arr.length; i++) {
			sum = sum+arr[i];
		}
		System.out.println("Las suma del array = "+sum);
	}
}