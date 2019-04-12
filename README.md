# kotlin-rsa
RSA Cryptosystem implementation in Kotlin

## CLI Usage

| Parameter | Type | Description | Format |
| --- | --- | --- | --- |
| --file | String | Absolute Path to input file | CSV or Text
| --public-key | String | Absolute path to public key file | (n,e)
| --private-key | String | Absolute path to private key file | (n,d)
| --encrypt | Switch | Flag to encrypt the input file using the given public key or generating a new random one |
| --decrypt | Switch | Flag to decrypt the input file using the given private key |

## Example
--file=input/cipher.txt --private-key=input/sk.txt --decrypt

--file=C:\Users\Linus\Desktop\input.txt --encrypt