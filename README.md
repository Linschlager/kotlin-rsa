# kotlin-rsa
RSA Cryptosystem implementation in Kotlin
You can find the executable JAR-file in [here](/artifacts/rsa-in-kotlin.jar)

***Disclaimer: This is a purely educational project and should not be used in a production environment***

## CLI Usage

| Parameter | Type | Description | Format |
| --- | --- | --- | --- |
| --file | String | Path to input file | CSV of encrypted chars or Text
| --out | String | Path to output file | CSV of encrypted chars or Text
| --public-key | String | Path to public key file | (n,e)
| --out-public-key | String | Desired path to public key file | (n,e) 
| --private-key | String | Path to private key file | (n,d)
| --out-private-key | String | Desired path to private key file | (n,d)
| --encrypt | Switch | Flag to encrypt the input file using the given public key or generating a new random one |
| --decrypt | Switch | Flag to decrypt the input file using the given private key |
| --debug | Switch | Flag to enable debug output of Keys used (Public/Private Key)

*Currently, the program does not overwrite any existing files but rather throw an error and abort*

## Example
java -jar rsa-in-kotlin.jar --file=input/cipher.txt --private-key=input/sk.txt --decrypt --out=output/text.txt

java -jar rsa-in-kotlin.jar --file=C:\Users\Linus\Desktop\input.txt --encrypt --out-private-key=output/private.txt --out-public-key=output/public.txt --out=output/cipher.txt
