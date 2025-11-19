using UnityEngine;

public class camera_control : MonoBehaviour
{
    private GameObject player = null;
    private Vector3 position_offset = Vector3.zero;

    private void Start()
    {
        player = GameObject.FindGameObjectWithTag("Player");  
        position_offset = transform.position - player.transform.position;
    }

    private void LateUpdate()
    {
        Vector3 new_position = transform.position;
        new_position.x = player.transform.position.x + position_offset.x;
        transform.position = new_position;
    }
}
