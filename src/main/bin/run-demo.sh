target="$0"
bin=`dirname "$target"`
SYMLINK_RESOLVED_BIN=`cd "$bin"; pwd -P`
ROOT_DIR=`dirname "$SYMLINK_RESOLVED_BIN"`

LIB_DIR=$ROOT_DIR/lib
CLASSPATH=""

while read -d '' -r jarfile ; do
    if [[ $CLASSPATH = "" ]]; then
        CLASSPATH="$jarfile";
    else
        CLASSPATH="$CLASSPATH":"$jarfile"
    fi
done < <(find "$LIB_DIR" ! -type d -name '*.jar' -print0)


java -cp $CLASSPATH net.company.PSRDemo $1
