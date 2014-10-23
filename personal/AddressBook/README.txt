Instructions for use in Eclipse

- Right click on AddressBookFixerImpl.java and choose Run Configurations.
- Add your input file and out file names and paths to the arguments tab
- Click on Run

The input file should be parsed and output file created.

In terms of usage for 1 million records. If 11,000 records are parsed and created
in 1 second then 1 million should take

1 / 11000 * 1000000 = 90 seconds

11000 records used approx 14MB of space to process so 1 million should used

14 / 110000 * 1000000 = 1272MB

in which case please add

-Xmx2048m

to your jvm arguments



