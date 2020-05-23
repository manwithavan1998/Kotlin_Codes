
private fun readLn() = readLine()!! // string line
private fun readInt() = readLn().toInt() // single int
private fun readLong() = readLn().toLong() // single long
private fun readDouble() = readLn().toDouble() // single double
private fun readStrings() = readLn().split(" ") // list of strings
private fun readInts() = readStrings().map { it.toInt() } // list of ints
private fun readLongs() = readStrings().map { it.toLong() } // list of longs
private fun readDoubles() = readStrings().map { it.toDouble() } // list of doubles

fun main(args: Array<String>) {
 	var n = readInt()
 	var a = readInts()
 	var mp = HashMap<Int,Int>()
 	for(i in 0..n-1){
 		if(mp.containsKey(a[i])==true){
 			var x = mp[a[i]]!!
 			mp[a[i]] = x + 1
 		}
 		else{
 			mp[a[i]] = 1
 		}
 	}
 	
 	var l = 0
 	var r = n
 	var ans = 0
 	while(l<=r){
 		var mid = (l+r)/2
 		var chk = 1
 		for(i in 1..mid){
 			if(mp.containsKey(i)==false){
 				chk = 0
 				break
 			}
 			else{
 				if(mp[i]!=2){
 					chk = 0
 					break
 				}
 			}
 		}
 		
 		if(chk == 1){
 			var temp1 = IntArray(mid + 1)
 			var vis = IntArray(n)
 			for(i in 1..mid){
 				temp1[i] = -1
 			}
 			var permutation = IntArray(mid + 1)
 			var prev = 0
 			var idx = 0
 			for(i in 0..n-1){
 				if(a[i]<=mid && temp1[a[i]] == -1){
 					permutation[idx++] = a[i]
 					temp1[a[i]] = 1
 					vis[i] = 1
 				}
 			}
 			for(i in 1..mid){
 				temp1[i] = -1
 			}
 			idx = 0
 			for(i in 0..n-1){
 				if(idx>=mid){
 					break
 				}
 				if(vis[i] == 0){
 					if(a[i] == permutation[idx]){
 						idx++
 					}
 				}
 			}
 			if(idx < mid){
 				chk = 0
 			}

 		}
 		if(chk == 1){
 			ans = maxOf(ans,mid)
 			l = mid + 1
 		}
 		else{
 			r = mid - 1
 		}
 	}
 	//println(ans)
 	var per = IntArray(ans+1)
 	
 	for(i in 0..n-1){
 		if(a[i]<=ans){
 			if(per[a[i]] == 0){
 				print("R")
 				per[a[i]]++
 			}
 			else{
 				print("G")
 			}
 		}
 		else{
 			print("B")
 		}
 	}
 	println()
}
