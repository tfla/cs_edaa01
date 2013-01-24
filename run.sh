#! /bin/bash
# Launch script for cs_eda016

# Function for determining wether classfiles should be run with junit
# and hamcrest. Also used to determine wether the folder is valid.
contains() {
	n=$#
    value=${!n}
    for  in $#; do
        if [[ "${!i}" == "${value}" ]]; then
            echo "y"
            return 0
        fi
    done
    echo "n"
    return 1
}

# Check if ./bin/ exists.
dir=./bin
if [ -d $dir ]; then
	echo "$dir exists, proceeding ..."
else
	echo "$dir does't exist, please run install.sh ... "
	exit 0
fi

# Path to the junit and hamcrest .jars.
junit=./junit-4.11.jar:
hamcrest=./hamcrest-all-1.3.jar:

# Array for projects that need junit and hamcrest to run.
jharr=("lab01" "banktest")

#Select what to run.
PS3='Choose a folder to use: '
select folder in $( ls $dir ); do
	# Array for valid folders.
	valid=("lab01" "lab02" "lab03" "lab04" "lab05" "lab06" "banktest")
	
	# Check that $dir is valid.
	if [[ $(contains "${valid[@]}" "${dir}") == "n" ]]; then
		echo "That's not a correct folder, exiting ..."
		break
	elif [[ $(contains "${valid[@]}" "${dir}") == "y" ]]; then
		
		# Select a package.
		PS4='Choose a package to use: '
		select pkg in $( ls $dir/$folder ); do

			# Select a classfile.
			PS5='Choose a file to run: '
			select classfile in $( ls $dir/$folder/$pkg ); do
				classfile=`echo $classfile | sed 's/\..\{5\}$//'`
				cd $dir/$folder/
				
				# Check if junit and hamcrest are needed.
				if [[ $(contains "${jharr[@]}" "${dir}") == "n" ]]; then
					java "$pkg"."$classfile"
				elif [[ $(contains "${array[@]}" "${var}") == "y" ]]; then
					java -cp "$junit""$hamcrest" org.junit.runner.JUnitCore "$pkg"."$classfile"
				fi
				break
			done
			break
		done
	fi
	break
done

exit 0
