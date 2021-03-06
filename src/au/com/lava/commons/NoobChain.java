package au.com.lava.commons;

import java.util.ArrayList;

public class NoobChain {
	
	//https://medium.com/programmers-blockchain/creating-your-first-blockchain-with-java-part-2-transactions-2cdac335e0ce
	
//	public static void main(String[] args) {
//		
//		Block genesisBlock = new Block("Hi im the first block", "0");
//		System.out.println("Hash for block 1 : " + genesisBlock.hash);
//		
//		Block secondBlock = new Block("Yo im the second block",genesisBlock.hash);
//		System.out.println("Hash for block 2 : " + secondBlock.hash);
//		
//		Block thirdBlock = new Block("Hey im the third block",secondBlock.hash);
//		System.out.println("Hash for block 3 : " + thirdBlock.hash);
//		
//	}
	public static ArrayList<Block> blockchain = new ArrayList<Block>(); 
	public static int difficulty = 5;
	
//	public static void main(String[] args) {	
//		//add our blocks to the blockchain ArrayList:
//		blockchain.add(new Block("Hi im the first block", "0"));		
//		blockchain.add(new Block("Yo im the second block",blockchain.get(blockchain.size()-1).hash)); 
//		blockchain.add(new Block("Hey im the third block",blockchain.get(blockchain.size()-1).hash));
//		
//		String blockchainJson = new GsonBuilder().setPrettyPrinting().create().toJson(blockchain);		
//		System.out.println(blockchainJson);
//	}

	public static void main(String[] args) {	
		//add our blocks to the blockchain ArrayList:
		
//		blockchain.add(new Block("Hi im the first block", "0"));
//		System.out.println("Trying to Mine block 1... ");
//		blockchain.get(0).mineBlock(difficulty);
//		
//		blockchain.add(new Block("Yo im the second block",blockchain.get(blockchain.size()-1).hash));
//		System.out.println("Trying to Mine block 2... ");
//		blockchain.get(1).mineBlock(difficulty);
//		
//		blockchain.add(new Block("Hey im the third block",blockchain.get(blockchain.size()-1).hash));
//		System.out.println("Trying to Mine block 3... ");
//		blockchain.get(2).mineBlock(difficulty);	
//		
//		System.out.println("\nBlockchain is Valid: " + isChainValid());
//		
//		String blockchainJson = new GsonBuilder().setPrettyPrinting().create().toJson(blockchain);
//		System.out.println("\nThe block chain: ");
//		System.out.println(blockchainJson);
		
		System.out.println("Trying to Mine block 1... ");
		addBlock(new Block("Hi im the first block", "0"));
		
		System.out.println("Trying to Mine block 2... ");
		addBlock(new Block("Yo im the second block",blockchain.get(blockchain.size()-1).hash));
		
		System.out.println("Trying to Mine block 3... ");
		addBlock(new Block("Hey im the third block",blockchain.get(blockchain.size()-1).hash));	
		
		System.out.println("\nBlockchain is Valid: " + isChainValid());
		
		String blockchainJson = StringUtil.getJson(blockchain);
		System.out.println("\nThe block chain: ");
		System.out.println(blockchainJson);
	}
	
	public static Boolean isChainValid() {
		Block currentBlock; 
		Block previousBlock;
		String hashTarget = new String(new char[difficulty]).replace('\0', '0');
		
		//loop through blockchain to check hashes:
		for(int i=1; i < blockchain.size(); i++) {
			currentBlock = blockchain.get(i);
			previousBlock = blockchain.get(i-1);
			//compare registered hash and calculated hash:
			if(!currentBlock.hash.equals(currentBlock.calculateHash()) ){
				System.out.println("Current Hashes not equal");			
				return false;
			}
			//compare previous hash and registered previous hash
			if(!previousBlock.hash.equals(currentBlock.previousHash) ) {
				System.out.println("Previous Hashes not equal");
				return false;
			}
			//check if hash is solved
			if(!currentBlock.hash.substring( 0, difficulty).equals(hashTarget)) {
				System.out.println("This block hasn't been mined");
				return false;
			}
		}
		return true;
	}
	
	public static void addBlock(Block newBlock) {
		newBlock.mineBlock(difficulty);
		blockchain.add(newBlock);
	}
//	public static Boolean isChainValid() {
//		Block currentBlock; 
//		Block previousBlock;
//		
//		//loop through blockchain to check hashes:
//		for(int i=1; i < blockchain.size(); i++) {
//			currentBlock = blockchain.get(i);
//			previousBlock = blockchain.get(i-1);
//			//compare registered hash and calculated hash:
//			if(!currentBlock.hash.equals(currentBlock.calculateHash()) ){
//				System.out.println("Current Hashes not equal");			
//				return false;
//			}
//			//compare previous hash and registered previous hash
//			if(!previousBlock.hash.equals(currentBlock.previousHash) ) {
//				System.out.println("Previous Hashes not equal");
//				return false;
//			}
//		}
//		return true;
//	}

}
